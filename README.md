# KotlinFlowDelayReproducer
An attempt to reproduce the Kotlin Flow collecting delay crash by using a sample `callbackFlow` to send some items and trying to collect them inside the ViewModel. The `delay` method is used inside the `collect` operator.

To check out the ViewModel: [click here](https://github.com/andreimesina/KotlinFlowDelayReproducer/blob/master/app/src/main/java/com/andreimesina/kotlinflowdelayreproducer/MainViewModel.kt).
