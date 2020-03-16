// Performing multiple filter operations on an input list
studentList
  .filter { student -> student.grade == 11 }
  .filter { student -> student.gpa > 3.5 }
