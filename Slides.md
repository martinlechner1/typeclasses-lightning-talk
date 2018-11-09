## Motivation

- Prefer composition over inheritance
- Inject behavior
- ADTs
- overloading of functions for every type needed

## Typeclass derivation

- Idea: You don't want to write the typeclass instances for product types (case classes)
- Example: Auto Derivation of Circe Encoders/Decoders
- Given: Instances for basic types
- Library generates the instances for your objects
- Shapeless
  - Most mature solution
  - Long compile times
- Magnolia
  - Still experimental
  - Way faster
