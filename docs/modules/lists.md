# Lists `static`

## Methods

### `getEntryBasedOnWeight(input: WeightedInput[])`

#### `WeightedInput`

Is a specific type of data that this method will require! The type looks like the following:

```typescript
const inputData = [{
    weight: 0.3,
    entry: "hello" // (Entry can be anything!)
}]
```

This method will take a list of the above data and based on the weight property / field will return a random item from the list. The randomness is bound to the weight meaning an entry with a higher weight is more likely to get picked than one with a lower weight.

`@return entry` the entry field of the `inputData`

```javascript
const entry = Ku.Lists.getEntryBasedOnWeight([
    {
        weight: 0.3,
        entry: "hello"
    },
    {
        weight: 0.2,
        entry: "hello2"
    },
    {
        weight: 0.6,
        entry: "hello3" 
    }
])

console.log(entry) // "hello" // One of the entries from above but missing the weight
```
