def call() {
    // Increase this timeout to give SonarQube time to process
    timeout(time: 10, unit: 'MINUTES') { 
        def qg = waitForQualityGate()
        if (qg.status != 'OK') {
            error "Pipeline aborted due to quality gate failure: ${qg.status}"
        }
    }
}
