# Kube Utils Changelog

## [0.1.4]

### Added

- A new `ku.player.starter-items` event that, once used and successfully gave items, will stop running
  - You can define an item and equipment slot (For things like armor) too
    ```javascript
    onEvent("ku.player.starter-items", event => {
        // Item.of is optional here 
        event.addItems("5x minecraft:gold_ingot", Item.of("2x minecraft:grass_block"))
    
        // Valid options are part of the EquipmentSlot Enum
        event.addEquipmentItem("chest", "minecraft:golden_chestplate")
        event.addEquipmentItem("offhand", "minecraft:stone")
    })
    ```
- A new `Ku.Player` class that brings some helpful methods
  - `showActionBar(text: string, color?: Color = Color.WHITE, bold = false, italic = false)`
    - Uses the built-in client action bar to display a message. This is already supported through the player class but this method allows for less boilerplate and stable code ports  
  - `showActionBarComponent(component: Component)`
    - Mostly the same as the above but gives you access to use a JS Object as your component which might look a something like this
      ```javascript
      const player = Ku.Player(event.player);
      player.showActionBarComponent({
         text: "Hello",
         bold: true
      })
      ```
  - `clearStarterItemsFlag`
    - This method simply reset the flag for the `ku.player.starter-items` meaning on the next login, the player will be given the items once again
  - `isClientSide`
    - Lets you know if the client being wrapped is client side. This was mostly a helper for my code but it could be helpful

### Changed 

- Renamed the internal binding classes to be suffixed with Ku so they're visually different from vanilla and KubeJS
