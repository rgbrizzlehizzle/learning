// The Vararg modifier
fun helloVarargs(greetings: String, vararg names: String) {
  names.forEach { name ->
    println("$greeting $name")
  }
}


fun main(args: Array<String>) {
  helloVarargs("Hello", "Android", "Kotlin")
}
