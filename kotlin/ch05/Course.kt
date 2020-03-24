class Course(courseTitle: String) {
  val title = courseTitle
  var description = ""
  // If you want, you can add custom getters and setters

}

/* For fun, here is the decompiled byte code of this simple class
public final class Course {
   @NotNull
   private final String title;

   @NotNull
   public final String getTitle() {
      return this.title;
   }

   @NotNull
   public final String getDescription() {
      return this.description;
   }

   public final void setDescription(@NotNull String var1) {
      Intrinsics.checkParameterIsNotNull(var1, "<set-?>");
      this.description = var1;
   }

   public Course(@NotNull String courseTitle) {
      Intrinsics.checkParameterIsNotNull(courseTitle, "courseTitle");
      super();
      this.title = courseTitle;
   }
}
*/

public static void main() {
  val course = Course("Mastering Kotlin")
  val courseTitle = course.title
}
