# Utils `static`

## Methods

### `nullOrEmpty(input: any)`

An absolute check on if any inputting `item / block / blockstate / itemEntity / string / resource location / fluid / itemstack` etc is null or empty.

`@return boolean` if the input is null or empty

```javascript
const isEmpty = new Ku.Utils.nullOrEmpty("minecraft:air");
const isEmpty2 = new Ku.Utils.nullOrEmpty(Items.AIR);
const isEmpty3 = new Ku.Utils.nullOrEmpty(Fluids.WATER);

console.log(isEmpty) // true
console.log(isEmpty2) // true
console.log(isEmpty2) // false
```

### `notNullOrEmpty(input: any)`

Same as the above but inverse. If the input is **NOT** null or empty.

`@return boolean` if the input is **NOT** null or empty
