// Example first class function
fun helloFunctions(greeting: String) {
  println("$greeting Kotlin Functions")
}

// Read-only function variables
val greetingProvider: () -> String = { "Hello" }
// Mutable function variable
var mutableGreetingProvider: () -> String = { "Yo" }
// Nullable mutable function var
var nullableMutableGreeting: (() -> String)? = null

fun main(args: Array<String>) {
  var greeting = greetingProvider() // invoke read-only func var
  greeting = greetingProvider.invoke() // does the same thing
  helloFunctions(greeting)
  println(mutableGreetingProvider())
  mutableGreetingProvider = { "Allo" }
  println(mutableGreetingProvider())
  // Nullable functions must be invoked by elvis operator when assigned to nonnull types
  nullableMutableGreeting?.invoke()
}

class GreetingViewModel {
  private val greetings = listOf("Hey", "Hi", "Whattup")
  
  // Functions as parameters
  fun printGreetings(filter: (String) -> Boolean) {
    greetings
        .filter(filter)
        .forEach { greeting -> 
            println(greeting)
        }
  }

  // Function as return type
  fun getGreetingProvider(isFriendly: Boolean) : () -> List<String> {
    return if(isFriendly) {
      { listOf("Hi", "Hey", "Hello") }
    } else {
      { listOf("Go away", "Leave me alone") }
    }
}
