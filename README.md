

# **SISTEMA DE GESTIÓN DE INVENTARIO - MVP**


**Desarrollado por:** Andrea Castrillón Puerta 
**Fecha de desarrollo:** octubre- noviembre, 2023.  

## **DESCRIPCIÓN**

Sistema de inventario para la gestión de componentes importados de China y Japón, para ensamblaje de motocicletas en Colombia, con almacenes ubicados en Bogotá, Medellín y Cali, desde ahí se envían a los talleres de ensamble según sea requerido. El sistema permite llevar un inventario que registra el ingreso y salida de componentes del almacén, sea para distribución a talleres o devoluciones a proveedores; también el registro de componentes en stock y disponibles en cada almacén, al igual que las cantidades mínimas y máximas de componentes que pueden ser almacenados en cada almacén.

## **STACK TECNOLÓGICO**  


### **BASE DE DATOS**

- Motor de base de datos: Oracle 21c XE
- Gestor de base de datos: DBeaver versión 23.2.1

### **BACKEND**

- Java - JDK versión 11.0.16
- Spring Boot - versión 2.7.17
- Gradle - versión 7.5.1
- Editor de código: IntelliJ IDEA Comunity Edition 2023.2.2

#### **DEPENDENCIAS BACKEND**


Dependencias en el archivo gradle.build del proyecto Spring Boot.


dependencies {  
  implementation("org.springframework.boot:spring-boot-starter-data-jpa")  
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")  
    implementation("org.springframework.boot:spring-boot-starter-web")  
    developmentOnly("org.springframework.boot:spring-boot-devtools")  
    runtimeOnly("com.oracle.database.jdbc:ojdbc8")  
    testImplementation("org.springframework.boot:spring-boot-starter-test")  
    implementation 'com.fasterxml.jackson.datatype:jackson-datatype-hibernate5:2.13.0'  
}  
  

### **FRONTEND**

- TypeScript - versión 5.1.3
- Angular - versión 16.2.0
- Editor de código: Visual Studio Code versión 1.84.2

#### **DEPENDENCIAS BACKEND**

Todas las dependencias pueden instalarse utilizando el siguiente comando en alguna consola abierta en la carpeta raíz del proyecto.  

    npm install nombre_de_dependencia

Dependencias en el archivo package.json en el proyecto Angular.  

    "@angular/animations": "^16.2.0",

	"@angular/common": "^16.2.0",

	"@angular/compiler": "^16.2.0",

	"@angular/core": "^16.2.0",

	"@angular/forms": "^16.2.0",

	"@angular/platform-browser": "^16.2.0",

	"@angular/platform-browser-dynamic": "^16.2.0",

	"@angular/router": "^16.2.0",

	"rxjs": "~7.8.0",

	"tslib": "^2.3.0",

	"zone.js": "~0.13.0"


## **INSTALACIÓN**


#### **INSTALACIÓN BASE DE DATOS**

- Verificar que el nuevo entorno tenga instalada una instancia de base de datos de Oracle 21 XE
- Ubicar el script TC_GB_02_SCHEMA_SCRIPT.sql que se encuentra en  
- Utilizar SQL PLus o SQL Developer para ejecutar los scripts TABLESPACE, SCHEMA y GRANT que se encuentran en 
- Utilizar SQL PLus o SQL Developer para ejecutar el script TC_GB_02_SCHEMA_SCRIPT.sql desde el usuario APP_M_INVENTARIO
- Verificar que los objetos hayan sido creados correctamente


#### **INSTALACIÓN BACKEND**

- Verificar que el nuevo entorno tenga instalados los elementos que componen el [stack tecnológico del backend](#backend)


#### **INSTALACIÓN FRONTEND**

- Verificar que el nuevo entorno tenga instalados los elementos que componen el [stack tecnológico del frontend](#frontend)

