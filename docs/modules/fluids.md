# Fluids `static`

## Methods

### `getFluidsByNamespace(namespace: string)`

This method will get you a list of fluids based on the inputted namespace. The namespace is able to be set to null but if this is the case, you will get a null response.

`@return null | net.minecraft.world.level.material.Fluid[]`

```javascript
const fluids = Ku.Fluids.getFluidsByNamespace("minecraft")
console.log(fluids) // [Fluid.WATER, Fluid.LAVA]
```

### `getFluidsByNamespaces(namespaces: string[])`

This method is very much the same as the above method but instead of a single namespace, you can query a list of namespaces.

A namespace in this context is a modid or minecraft.

`@return net.minecraft.world.level.material.Fluid[]`

```javascript
const fluids = Ku.Fluids.getFluidsByNamespaces(["minecraft", "thermal"])
console.log(fluids) // [Fluid.WATER, Fluid.LAVA, Fluid.CREOSOTE] (Example responses)
```

### `notEmpty(fluid: net.minecraft.world.level.material.Fluid)`

This method will check if a fluid is **NOT** empty.

`@return boolean`

### `isEmpty(fluid: net.minecraft.world.level.material.Fluid)`

Helper method to the above, this method will tell you a fluid is empty.

`@return boolean`
