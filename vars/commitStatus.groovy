def call(String name = "Unknown", Map config) {
    script {
        sh """#!/bin/bash
            set -e
            uname -a
            id
            pwd
            ls -laF .
            echo Hi ${name}
            #
            curl -L \
                -X POST \
                -H "Accept: application/vnd.github+json" \
                -H "Authorization: Bearer ${config.token}" \
                -H "X-GitHub-Api-Version: 2022-11-28" \
                https://api.github.com/repos/${config.owner}/${config.repo}/statuses/${config.sha} \
                -d '{"state":"${config.state}","target_url":"${config.targetUrl}","description":"${config.desc}","context":"${config.context}"}'
        """
    }
}
