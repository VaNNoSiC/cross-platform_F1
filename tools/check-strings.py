import sys
import xml.etree.ElementTree as ET
from pathlib import Path


PROJECT_ROOT = Path(__file__).resolve().parent.parent

STRINGS_DIR = (
    PROJECT_ROOT /"shared"/"src"/"commonMain"/"composeResources"
)

LOCALES = {
    "en": STRINGS_DIR /"values"/"strings.xml",
    "ru": STRINGS_DIR /"values-ru"/"strings.xml",
}


def get_string_keys(file_path: Path) -> set[str]:
    if not file_path.exists():
        print(f"ERROR: File not found: {file_path}")
        sys.exit(1)

    try:
        root = ET.parse(file_path).getroot()
    except ET.ParseError as error:
        print(f"ERROR: Invalid XML in {file_path}")
        print(error)
        sys.exit(1)

    keys = set()

    for element in root.findall("string"):
        name = element.get("name")

        if not name:
            print(f"ERROR: Found <string> without a name in {file_path}")
            sys.exit(1)

        keys.add(name)

    return keys


def main() -> int:
    locale_keys = {
        locale: get_string_keys(path)
        for locale, path in LOCALES.items()
    }

    for locale, keys in locale_keys.items():
        print(f"{locale}: {len(keys)} keys")

    print()

    reference_locale = "en"
    reference_keys = locale_keys[reference_locale]

    success = True

    for locale, keys in locale_keys.items():
        if locale == reference_locale:
            continue

        missing = reference_keys - keys
        extra = keys - reference_keys

        if missing:
            success = False
            print(f"ERROR: Keys missing in {locale}:")
            for key in sorted(missing):
                print(f"  - {key}")

        if extra:
            success = False
            print(f"ERROR: Extra keys in {locale}:")
            for key in sorted(extra):
                print(f"  - {key}")

    if success:
        print("OK")
        return 0

    print()
    print("String resource check FAILED.")
    return 1


if __name__ == "__main__":
    raise SystemExit(main())