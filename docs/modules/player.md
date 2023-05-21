# Player `constructed`

Player is a `constructed` helper meaning you must create it before use. An example of this may look like the following:

```javascript
const player = getPlayerFromSomewhere();
const kuPlayer = new Ku.Player(player);

// You can now use kuPlayer to utilise it's methods found below

// Another example might look more like 
PlayerEvents.tick((event) => {
    const player = event.player;
    const kuPlayer = new Ku.Player(player);
})
```

## Methods

### `showActionBarComponent(component: Component)`

Displays a message in the clients action bar (The bit above the inventory). Specifically this method allows you to pass an abstract Compound to the method and we'll handle the rest. 


```javascript
const kuPlayer = new Ku.Player(player);
kuPlayer.showActionBarComponent({
    "text": "Hello",
    "bold": true
})
```

### `showActionBar(text: String)`

Same as the above but only supports a string input

```javascript
const kuPlayer = new Ku.Player(player);
kuPlayer.showActionBar("hello")
```

### `showActionBar(text: String, color: color)`

Same as the above but only supports a string input and supports a color input

```javascript
const kuPlayer = new Ku.Player(player);
kuPlayer.showActionBar("hello", "blue")
```

### `showActionBar(text: String, color: color, bold: boolean)`

Same as the above but only supports a string input, supports a color input, and if the text should be bold

```javascript
const kuPlayer = new Ku.Player(player);
kuPlayer.showActionBar("hello", Color.BLUE, true)
```

### `clearStarterItemsFlag()`

Part of the [Start item system](../systems/starter-items.md). Allows you to manually clear the flag on the player that prevents them getting starter items again.

`@return boolean` if the clear was successful

```javascript
const kuPlayer = new Ku.Player(player);
const success = kuPlayer.clearStarterItemsFlag()
console.log(success) // true
```

### `isClientSide()`

Returns if the player is a local player of if they're a multiplayer player.

```javascript
const kuPlayer = new Ku.Player(player);
const isClient = kuPlayer.isClientSide()
console.log(isClient) // true
```


