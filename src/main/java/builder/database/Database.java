package builder.database;

import lombok.Getter;
import lombok.Setter;

public class Database {
    private String name;
    private String host;
    private Integer port;
    private String password;

    private Database(){}

    @Getter
    public static class DatabaseBuilder{
        private String name;
        private String host;
        private Integer port;
        private String password;
        private DatabaseBuilder(){}

        public static DatabaseBuilder toBuilder(){
            DatabaseBuilder databaseBuilder = new DatabaseBuilder();
            return databaseBuilder;
        }

        public DatabaseBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public DatabaseBuilder withHost(String host) {
            this.host = host;
            return this;
        }

        public DatabaseBuilder withPort(Integer port) {
            this.port = port;
            return this;
        }

        public DatabaseBuilder withPassword(String password) {
            this.password = password;
            return this;
        }

        public Database build(){
            Database database = new Database();
            database.name = this.name;
            database.host = this.host;
            database.port = this.port;
            database.password = this.password;
            return database;
        }
    }
}
