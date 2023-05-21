# Streams `static`

## Methods

### `mapToBlock(level: Level | ServerLevel, locations: BlockPos[])`

Helper method to take a list of BlockPos locations and turn them into BlockContainerJS data

```javascript
const blocks = new Ku.Streams.mapToBlock(level, [{x: 0, y: 0, z: 0}]);

for (const block of blocks) {
    console.log(block.state) // minecraft:grass 
}
```
