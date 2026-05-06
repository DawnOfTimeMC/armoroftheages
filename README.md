<div align="center">
  <img src="https://i.imgur.com/Ii1YRVj.png" alt="Armor of the Ages" width="500">
  <br><br>
  <img src="https://i.imgur.com/NpfnNgr.gif" alt="Armor of the Ages showcase">
  <br><br>

[![Discord](https://img.shields.io/badge/discord-join-5865F2?style=flat-square&logo=discord&logoColor=white&labelColor=0d1117)](https://discord.gg/k4gN2b7Zam)
[![CurseForge](https://img.shields.io/badge/curseforge-download-F16436?style=flat-square&logo=curseforge&logoColor=white&labelColor=0d1117)](https://www.curseforge.com/minecraft/mc-mods/armor-of-the-ages)
[![Modrinth](https://img.shields.io/badge/modrinth-download-1bd96a?style=flat-square&logo=modrinth&logoColor=white&labelColor=0d1117)](https://modrinth.com/mod/armor-of-the-ages)
[![Patreon](https://img.shields.io/badge/support-patreon-FF424D?style=flat-square&logo=patreon&logoColor=white&labelColor=0d1117)](https://www.patreon.com/cw/dawnoftimemod)

</div>

**Armor of the Ages** is a Minecraft mod that adds animated armor sets inspired by cultures from across history. Craft the armor of an Egyptian pharaoh, a Roman centurion, or a Japanese samurai. Wear your legend.

Part of the **[Dawn of Time](https://www.curseforge.com/members/dawnoftime_team/projects)** mod ecosystem.

<div align="center"><img src="https://i.imgur.com/yhha6Zo.png"></div>

## Features

- **11 unique armor sets** with custom 3D animated models
- **Male & female model variants**, automatically matched to your skin type (slim/Alex)
- **Fully configurable stats** in-game: durability, defense, enchantability, toughness
- **Loot table integration**: armor pieces generate naturally in world chests (toggleable per set)
- Available on both **Forge** and **Fabric**

<div align="center"><img src="https://i.imgur.com/yhha6Zo.png"></div>

## Configuration

Armor of the Ages uses **[YACL (Yet Another Config Lib)](https://modrinth.com/mod/yacl)** for its in-game configuration screen.

- Preferred armor model (male/female), synced between players on a server
- Per-armor stats: durability, defense per slot, enchantability, toughness
- Enable or disable loot table generation globally or per armor set

Configuration is saved to `config/armoroftheages.json`.

<div align="center"><img src="https://i.imgur.com/yhha6Zo.png"></div>

## Overriding Recipes

All recipes can be overridden or removed via a datapack, without modifying the mod itself. This is useful for modpacks or custom servers.

**Datapack structure:**

```
my_datapack/
├── pack.mcmeta
└── data/
    └── armoroftheages/
        └── recipes/
            └── <recipe_name>.json
```

**`pack.mcmeta`** (required at the root of the datapack):

```json
{
    "pack": {
        "pack_format": 15,
        "description": "My custom AotA recipes"
    }
}
```

`pack_format: 15` is the correct value for Minecraft 1.20.1.

**Installation:** place the datapack folder (or its `.zip`) in:
- Single-player: `.minecraft/saves/<world_name>/datapacks/`
- Server: `<server_root>/world/datapacks/`

Then run `/reload` in-game or restart the server.

---

**Override a recipe** by placing a custom `.json` file at the matching path. The full list of recipe files is available on GitHub:
- [Forge recipes](https://github.com/DawnOfTimeMC/armoroftheages/tree/1.20.1-master/forge/src/main/resources/data/armoroftheages/recipes)
- [Fabric recipes](https://github.com/DawnOfTimeMC/armoroftheages/tree/1.20.1-master/fabric/src/main/resources/data/armoroftheages/recipes)

**Remove a recipe** by overriding the file with an empty JSON object:

```json
{}
```

Minecraft will fail to parse the file, log a warning, and silently skip the recipe. The game loads normally — this is not a crash.

<div align="center"><img src="https://i.imgur.com/yhha6Zo.png"></div>

## Compatibility

| Mod | Status | Notes |
|---|---|---|
| [YACL](https://modrinth.com/mod/yacl) | ✅ Required | Config GUI |
| [ModMenu](https://modrinth.com/mod/modmenu) | 🔵 Fabric only | Config screen access |
| [Garden Trails](https://modrinth.com/mod/garden-trails) | ✅ Compatible | Silk replaces string ingredients in recipes |

<div align="center"><img src="https://i.imgur.com/yhha6Zo.png"></div>

## Credits

- Development, models and textures by **Poulpinou**
- Special thanks to **mr_ch0c0late** for the Centurion armor, and to **Hahdrim** for the Iron Plate armor!
- [Minecraft Title Generator](https://ewanhowell.com/plugins/minecraft-title-generator/) by Ewan Howell was used for the project name. [Support this guy](https://ko-fi.com/ewanhowell), he's a hero

*Licensed under [MIT](LICENSE.md)*

<div align="center"><img src="https://i.imgur.com/yhha6Zo.png"></div>

## Support

If you enjoy the mod, consider supporting the Dawn of Time team on **[Patreon](https://www.patreon.com/cw/dawnoftimemod)**. It helps keep the project alive and growing.

Join the community on **[Discord](https://discord.gg/k4gN2b7Zam)** to share feedback, report bugs, or just hang out.