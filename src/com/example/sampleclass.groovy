// common-lib/src/com/example/MySharedLibrary.groovy

package com.example

class MySharedLibrary implements Serializable {
    def echo(String message) {
        println "Hello from MySharedLibrary: $message"
    }
}
