#!/usr/bin/env bash


fail() {
  echo "There were errors"
}

end() {
  echo "Work is finished"
}

setChrome() {
   open -a "Google Chrome" http://localhost:8080/v1/task/getTasks
}
runTasksInBrowser() {

  xdg-open http://localhost:8080/crud/v1/task/getTasks
}

if ./runcrud.sh; then
   setChrome
   runTasksInBrowser

else

   fail
fi
