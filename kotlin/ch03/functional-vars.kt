fun main(args: Array<String>) {
  val stringFilter:(String) -> Boolean = { string -> string.length > 3 }

  val languages = listOf("C++", "PHP", "Java", "Kotlin")
  val filteredLanguages = languages.filter(stringFilter)

  // Same as
  val alsoFiltered = listOf("C++", "PHP", "Java", "Kotlin")
      .filter { string -> string.length > 3 }

}
