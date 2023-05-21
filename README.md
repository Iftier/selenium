#Selenium

there are mainly 4 way to waits in selenium

1. **sleep** : this is very hard wait -Example,'Thread.sleep(5000)
2. **Implicit wait** : it is to tell selenium to wait for certain time before it throws exception ,
    Implicit wait is valid for the life of the webdriver
3. **Explicit wait** : explicit wait is to tell the selenium/driver to wait certain time until certain 
   condition occurs before throwing the exception 
4. **Fluent wait** : fluent wait is ti tell selenium to wait maximum amount to wait 


### how to run test

run entire test suite

          mvn clean install

to run individual feature file

       mvn clean test -Dcucumber.features="path/to/the/file.feature"

to run tag

        mvn clean test -Dcucumber.filter.tags="@TagName"

### git commit 

    git init
    git add .
    git commit -m "first commit"
    git push -u orgine main
    git diff

to get update from github ti you local machine
       
        git pull

Check existing branches
   
    git branch
 
create a new branch 

    git checkout -b ghb_run_test
switch branches
     
     git checkout BRANCH_NAME