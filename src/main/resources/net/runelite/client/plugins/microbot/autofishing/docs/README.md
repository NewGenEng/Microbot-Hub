# Auto Fishing Plugin

The **Auto Fishing Plugin** automates fishing with banking support and special attack integration for various fishing methods.

---

## Feature Overview

| Feature                      | Description                                                    |
|-----------------------------|----------------------------------------------------------------|
| **Multiple Fishing Methods**| Supports net, bait, lure, harpoon, and cage fishing            |
| **Banking Integration**     | Automatically banks fish when inventory is full                |
| **Special Attack Support**  | Uses special attacks with harpoons when available              |
| **Fish Type Selection**     | Choose specific fish to catch at multi-fish spots              |
| **Location Detection**      | Automatically detects fishing spot locations                   |
| **Spot Preference (NEW)**   | Prefer spots by direction and/or coordinates (falls back to nearest) |
| **Overlay Display**         | Shows fishing statistics and current status                    |

---

## Requirements

- Appropriate fishing equipment (net, rod, harpoon, lobster pot, etc.)
- Bait if required (feathers, worms, etc.)
- Access to fishing spots
- Access to a bank for banking mode

---

## Supported Fishing Methods

| Method   | Equipment Required    | Bait Required  | Fish Types |
|----------|------------------------|----------------|------------|
| **Net**  | Small fishing net      | None           | Shrimp, Anchovies |
| **Bait** | Fishing rod            | Fishing bait   | Sardine, Herring, Pike |
| **Lure** | Fly fishing rod        | Feathers       | Trout, Salmon |
| **Harpoon** | Harpoon             | None           | Tuna, Swordfish |
| **Cage** | Lobster pot            | None           | Lobster |

---

## How fishing spots are selected

By default, the script looks for NPCs that match the fishing spot IDs for the selected fish, then chooses the **nearest** spot.

When **Spot preference** is enabled, the script will score each candidate spot and prefer:

- **+100** if a spot is inside your configured **coordinate bounds** (when enabled)
- **+50** if a spot matches your configured **direction** (when enabled)

If **no spot matches** your preference rules (score = 0), the script will **fall back to the nearest fishing spot**.

---

## Configuration Options

### General

| Setting                         | Description |
|---------------------------------|-------------|
| **Fish to catch**               | Select what fish to catch (and therefore what fishing spot NPCs are valid) |
| **Use bank**                    | Enable/disable automatic banking when inventory is full |
| **Cook fish**                   | Cook fish after fishing if a fire/range is nearby |
| **Harpoon spec**                | Choose the harpoon type for special attacks |
| **Toggle bank locks once on start (NEW)** | If enabled, bank locks are toggled **one time** the first time the script opens the bank, and the script will not toggle them back after each deposit. Useful for testing if repeated toggling causes issues. |

> Note: this option literally toggles once (it doesn’t “ensure enabled”). If your bank locks are already in the desired state before starting, toggling once will flip them.

### Spot preference (NEW)

| Setting | Description |
|--------|-------------|
| **Enable spot preference** | Enables preference scoring. If disabled, the script always uses the nearest spot. |
| **Preference origin** | What point the direction is relative to: **PLAYER** or **FISHING_LOCATION** (the tile the script walks to). |
| **Preferred direction** | Prefer spots **NORTH/SOUTH/EAST/WEST** of the origin. Use **ANY** to disable direction preference. |
| **Direction tolerance (tiles)** | Adds leeway so a spot can still count as NORTH/SOUTH/EAST/WEST even if it’s nearly aligned. |
| **Enable coordinate bounds** | Prefer spots within a coordinate rectangle. |
| **Min X / Max X / Min Y / Max Y** | The coordinate rectangle to prefer (world coordinates). |
| **Plane (-1 = any)** | Restrict bounds to a plane (0-3) or allow any plane (-1). |

---

## Examples / Recipes

### Example 1: Shilo Village – prefer the south river spots (closer to bank)

- Enable spot preference: **ON**
- Preferred direction: **SOUTH**
- Preference origin:
  - **FISHING_LOCATION** if you want a stable “south side of the river area” rule
  - **PLAYER** if you want “south of where I’m currently standing”
- Direction tolerance: **0** or **1**

Result: when there are multiple valid salmon spots, the script will prefer the ones that are **south** of your chosen origin.

### Example 2: “I’m standing one tile south of the fishing spot — how do I make it pick a different spot?”

This depends on what you want:

#### A) Pick a spot that’s south of *your current position*
Use **PLAYER** origin.

- Enable spot preference: **ON**
- Preference origin: **PLAYER**
- Preferred direction: **SOUTH**
- Direction tolerance: **0**

If you are already one tile south of a spot, that spot will likely be **north of you** (dy > 0), so it won’t match SOUTH. A different spot that’s actually south of you will be preferred.

#### B) Always pick the “south side” spots in an area, even if you move around
Use **FISHING_LOCATION** origin.

- Enable spot preference: **ON**
- Preference origin: **FISHING_LOCATION**
- Preferred direction: **SOUTH**
- Direction tolerance: **0** or **1**

This keeps the preference stable even if you drift 1–2 tiles while interacting.

#### C) Force selection into a specific region (most reliable)
Use **coordinate bounds**.

- Enable spot preference: **ON**
- Enable coordinate bounds: **ON**
- Set Min/Max X and Min/Max Y to cover only the tiles/area you want.

This is the best way to force “use this side of the river / this section of docks / closest-to-bank area”, regardless of where you’re standing.

---

## Troubleshooting

- If Spot preference is enabled but you don’t see different behavior:
  - Make sure **Preferred direction** is not set to **ANY** (if you’re testing direction)
  - Make sure coordinate bounds are valid (Min <= Max, all > 0)
  - Remember: if no spot matches the rules, the script falls back to the nearest spot.
