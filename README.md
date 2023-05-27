# TaterSync

A Minecraft Plugin/Mod to sync player data across servers.
Inspired by [HuskSync](https://www.spigotmc.org/resources/husksync-1-16-1-19-synchronize-player-inventories-data-cross-server.97144/), but with my own spin on it. I feel like there's a bit more that a cross-API implementation will allow, and I'm excited to see where this goes. Can't wait for serialization hell.

## TODO

- [ ] General Serialization
- [ ] Inventory data serialization
- [ ] Cross-API implementation
  - [ ] Need checks for modded-items, so they're not lost in translation
  - [ ] Need checks for version-specific items, so they're not lost in translation
  - [ ] Set some sort of placeholder item?
  - [ ] Set the item aside, and let the user know that they're not supported?
  - [ ] Implement temporary storage for error-ed items
- [ ] Need to get the timing down on player joins/disconnects
- [ ] Some sort of player store/bank -- similar to Borderlands
