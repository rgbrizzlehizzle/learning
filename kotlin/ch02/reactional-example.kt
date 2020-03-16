studentsObservable
  .filter { student -> student.grade == 11 } 
  .filter { student -> student.gpa > 3.5 }
  .subscribeBy(
    onNext = { displayStudents(it) },
    onError = { error -> error.printStackTrace() },
    onComplete = { println("Done!") }
  )

