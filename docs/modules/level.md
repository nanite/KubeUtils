# Level `constructed`

Level is a `constructed` helper meaning you must create it before use. An example of this may look like the following:

```javascript
const player = getPlayerFromSomewhere();
const kuLevel = new Ku.Level(player.level);

// You can now use kuLevel to utilise it's methods found below

// Another example might look more like 
PlayerEvents.tick((event) => {
    const player = event.player;
    const kuLevel = new Ku.Level(player.level);
})
```

## Methods

### `spawnStructure(structureFile: string, location: BlockPos)`

Spawn structure does as it says on the tin. Given a specific structure file (the structure file as a string version of the resource location aka: minecraft:structures/somestructure) and a block position the method will spawn the structure at that position.

```javascript
const kuLevel = new Ku.Level(...);
kuLevel.spawnStructure("minecraft:structures/village_1", BlockPos.ZERO);
```

**Notes**

This method fails softly meaning if the structure does not exist, the method will simply do nothing.

### `findEntitiesWithinRadius(entityId: EntityType, start: BlockPos, range: Number)`

Find entities within a radius based on an entity type. The entity type would typically look like `minecraft:skeleton`. You can typically find modded ones from the mods Java code. 

The search radius is from and expanded cube from the start block position. This means that a range of 1 would be a 3x3 cube with the start position in the middle.

`@return net.minecraft.world.entity.LivingEntity[]`

```javascript
const kuLevel = new Ku.Level(...);
const entities = kuLevel.findEntitiesWithinRadius("minecraft:skeleton", BlockPos.ZERO, 4);
console.log(entities)
```

### `findBlockWithinRadius(blockstate: BlockState, start: BlockPos, range: Number, absolute: boolean)`

Find blocks within a radius that match a given state. Depending on if the `absolute` flag is set to true will depend on if we compare the default state of the block or the absolute state of the block meaning the states **must** match.

The search radius is from and expanded cube from the start block position. This means that a range of 1 would be a 3x3 cube with the start position in the middle.

`@return BlockPos[]`

```javascript
const kuLevel = new Ku.Level(...);

// You could also get the state from the world.
const locations = kuLevel.findBlockWithinRadius(Blocks.GRASS.defaultState(), BlockPos.ZERO, 4, false);
console.log(locations) // [{x: 0, y: 0; z: 0}]
```

### `findSingleBlockWithinRadius(blockstate: BlockState, start: BlockPos, range: number, absolute: boolean)`

Very much the same as `findBlockWithinRadius` but instead will find the first block and return early with its position. If no block is found then we return null

`@return BlockPos | null`

### `getRandomLocation(start: BlockPos, min: Number, max: Number)`

Generate a random BlockPos within a min and max range.

The search radius for this is interesting. We form two bounding boxes (A bounding box is just a 3d cube). We then expand both of them to the min and max creating an inside and outside area. Anything that falls within the outside (max) bounding box and within the inside box (min) will have the possibility of being selected as one of the random locations

`@return BlockPos`

```javascript
const kuLevel = new Ku.Level(...);

const locations = kuLevel.getRandomLocation(BlockPos.ZERO, 1, 10);
console.log(locations) // [{x: 0, y: 0; z: 0}]
```

### `seekCollectionOfBlocks(start: BlockPos, range: Number, validator: (pos) -> boolean, @Nullable belowValidator: (pos) -> boolean)`

So this one is going to be fun. Let's talk about what this method does, the break down how you can manipulate it do some pretty cool this!

Extremely specific method that can find a group of blocks using a predicate to validate that the group of blocks are all compiling with the predicate before returning.

`startPos` the location to start searching from

`range` the range is a cube so starting with 1 would be a 3x3, 2 would be a 4x4, etc

`validator` this is a lambda validator. Each block will need to pass this validator. You will see a better example of this below but effectively, you're given the block positions one by one and you can run custom logic to determine if the block is valid.

`belowValidator` `(OPTIONAL)` when set, the block below the center will also have to pass a validator

** Notes **
This method will only ever return a list of block locations if the validation steps are successful, otherwise the method will return and empty list

`@return BlockPos[]`

```javascript
const level = event.level;
const kuLevel = new Ku.Level(...);

// The use of this validator requires all blocks to not be
// air.
const locations = kuLevel.seekCollectionOfBlocks(
    BlockPos.ZERO, // Start
    4,             // range
    (pos) => {     // validator
        // pos is provided by Kube Utils
        return !level.getBlockState(pos).isAir()
    },
    null
);
console.log(locations) // [{x: 0, y: 0; z: 0}]

// Using the below center condition as well.
// This use of the validators requires the blocks to not be air and for the block
// under the start pos to be a diamond block
const locations = kuLevel.seekCollectionOfBlocks(
    BlockPos.ZERO, // Start
    4,             // range
    (pos) => {     // validator
        // pos is provided by Kube Utils
        return !level.getBlockState(pos).isAir()
    },
    (pos) => {     // belowValidator
        // pos is provided by Kube Utils
        return level.getBlockState(pos).getBlock() == Blocks.DIAMOND_BLOCK
    },
);
console.log(locations) // [{x: 0, y: 0; z: 0}]
```

### `isStructureAtLocation(location: BlockPos, structureId: String | ResourceLocation)`

Attempts to check if a specific structure is at a specified block location using a structures resource location.

`@return boolean`

```javascript
const kuLevel = new Ku.Level(...);

const isThere = kuLevel.isStructureAtLocation(BlockPos.ZERO, "minecraft:structures/god_knows");
console.log(isThere) // true or false
```

### `getStructuresAtLocation(location: BlockPos)`

This method is relatively specific but it will return a list / set of `net.minecraft.world.level.levelgen.structure.Structure` references. You can use this method to check different information about the structures at a specific locaiton;

`@return Set<Structure>`

```javascript
const kuLevel = new Ku.Level(...);

const structures = kuLevel.isStructureAtLocation(BlockPos.ZERO);
console.log(structures)
```

### `getStructureIdsAtLocation(location: BlockPos)`

Like the more useful method of the structure methods as it will provide you a list of resource locations (strings) of structures that are present at a specific location.

`@return string[]`

```javascript
const kuLevel = new Ku.Level(...);

const structures = kuLevel.getStructureIdsAtLocation(BlockPos.ZERO);
console.log(structures) // ["minecraft:dungeon", "minecraft:jungle_mansion"]
```

### `blocksAreEqual(firstState: BlockState, secondState: BlockState, ignoreState: boolean)` `static`

Will compare two different block states to see if their state data match. You can pass `ignoreState` as `true` if you want the method to check if the blocks match ignoring the state of the blocks.

`@return boolean`

```javascript
const isSame = Ku.Level.blocksAreEqual(Blocks.GRASS.defaultState(), Blocks.GRASS.defaultState());
console.log(isSame) // true
```

