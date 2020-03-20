fun main(args: Array<String>) {
  // Standard Non Nullable Variable
  var language: String = "Kotlin"
  // Error: Null can not be a value of a non-null type String
  // language = null
  
  // Variable that allows null type
  var nullLang: String? = "Kotlin"
  nullLang = null // this works

  // Because non null is default, calls to non null types are considered null safe
  var languages = listOf("Kotlin", "Java", "C++")
  languages.isNotEmpty() // Will never NPE!

  // Safe calls allow you to perform potentially dangerous operations without fear of NPE
  var companies: List<String>? = null
  companies?.isNotEmpty()
  // Safe calls can be chained ie: companies?.get(0)?.toLowerCase()
  
}

// Non null assertions (!!) allow you to check for potential null args
fun parseArgs(args: Array<String>?) {
  val argCount = args!!.size // Throws NPE if args is null
}

/*
If you use a non-null assertion call on a variable and then use that variable 
again after the call, the compiler will SmartCast the variable to a non-null 
type and you can omit any further safe or non-null assertion calls.
*/

// Also totally possible to check for null the lame way
fun parseArgs(args: Array<String>?) {
  val argCount = if(args != null) args.size else 0
}

// LMFAO The Elvis Operator
//if args?.size is non null, use args.size, otherwise return 0
fun parseArgs(args: Array<String>?) {
    val argCount2 = args?.size ?: 0 // return 0 if args?.size is null
}
