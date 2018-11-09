# Typeclasses

## Motivation

This somewhat abstract title leads to a somewhat abstract concept commonly found in the scala ecosystem: typeclasses.

They allow you to abstract behavior and push concrete behavior for other people's data types out of your code.

Let's start with a simple example. You are the author of a library called fancyJson.
You want to offer a concise interface to users of your library allowing them to parse JSON into their data types.

You know how to parse JSON, you know how to parse simple types included in JSON like numbers, strings, lists...
You don't know how to parse a structure into the user's data structure.
You need some way to force the users to bring the evidence that their types can be parsed by your library. What to do?

Typeclasses to the rescue!

They can help you to stay in a abstract world in your library and push specifying the concrete details to the user.

In the json example you operate internally on Decoders parametrized with some type variable A.

The users need to provide Decoders for their types to make the library happy.
So the concrete specification of how to parse json into the user's structure is being pushed to them.

The json example is a bit hard, so let's go back to combining things as shown in my previous lightning talk: If you specify how to combine your new fancy data type, you are able to leverage a whole class of functions which are based on the Monoid typeclass for example combineAll.

The goal of this talk is giving you a short overview and what you need to know to be using them effectively.

## Semigroup.scala

I'm going to show you some implementation patterns you usually find in Libraries like Cats, Circe and others.

There is usually a parametrized trait specifying the behavor.
Then there are typeclass instances to specify for certain types how they behave.

From Scala 2.12 onwards there is also a short notation for specifying the instances as seen in the string example.

Then there is the function of the trait in the companion object to make it usable for the outside world. Notice that we need an implicit for the type we are using here.

Using apply we can even shorten it a bit more. apply is called there to get the correct instance.

Compared to the oop way of polymorphism with inheritance you can see that using typeclasses lead to less strong coupling and a separation of the actual data shape from the specification of the interface. The glue between behavior and data is the typeclass instance.

From a library user's perspective you need to specify how your stuff behaves in the context of the library. An example would be encoders and decoders in circe.

## SemigroupOps.scala

Sometimes you see fancy operators, e.g. |+| and infix usage of the functions. this can be done as shown here.

## Simulacrum.scala

As you just saw there is lots of boilerplate to be written to have useful typeclasses. Fortunately there is a library Simulacrum which provides you with annotations and macros to reduce the boilerplate by a lot. This is the same typeclass as shown earlier. Commented out is what simulacrum generates for us, the behavior is exactly the same.

## Typeclass derivation

Shapeless / Magnolia
When working with libraries using typeclasses it's often tedious to generate typeclass instances for every product type (e.g. case classes) you are using.

If you are wondering what circe auto derivation is doing: It's using shapeless under the hood to derive typeclasses for your data structure given internal decoders for basic types.

I won't go into much detail here, you just need to know that this might be useful. Shapeless has one big problem: It's slow. Using circe on very big case classes does make you hate the scala compiler, since the typeclass derivation can take up to minutes. There is a new experimental project called Magnolia, which works a bit different under the hood and is thus much faster.
