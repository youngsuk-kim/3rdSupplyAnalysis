allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.MappedSuperclass")
    annotation("javax.persistence.Embeddable")
}

dependencies {
    runtimeOnly("mysql:mysql-connector-java")
}
