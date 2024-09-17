def call(String name = "Unknown") {
    script {
        sh """#!/bin/bash
            set -e
            uname -a
            id
            pwd
            ls -laF .
            echo Hi ${name}
        """
    }
}
