# gestor-futbol-refactorizado

## BLOCKER

1. Remove this "clone" implementation; use a copy constructor or copy factory instead.

*From:*
```
@Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
```
*To:*
```
    public clone(Object obj) {
        Object clone = new Object();
        this.clone = this.obj;
    }
```
Para su correcta implementación también es necesario eliminar la implementación de *Clonable* en **GestorFutbol**.

2. Make sure this SonarQube token gets revoked, changed, and removed from the code.

*Modificar la visibilidad del token:*
```
sonar.login=sqa_01714030258bbcdde6974160a17915fb6b85b5e4
```

*Impementamos el token al comando* **sonar-scanner** *para aislarla del codigo:*

```
sonar-scanner -Dsonar.login=sqa_01714030258bbcdde6974160a17915fb6b85b5e4
```

## HIGH

1. File path "\Users\Usuario\Desktop\GIT\gestor-futbol-refactorizado" should match package name "practica_refactorizacion_casa". Move the file or change the package name.

*Renombrar la carpeta del proyecto de "gestor-futbol-refactorizado" a* **practica_refactorizacion_casa**


2. Refactor this method to reduce its Cognitive Complexity from 18 to the 15 allowed.

*Fácilmente obtenible descomponiendo las funcionalidades del método original en métodos más pequeños*
