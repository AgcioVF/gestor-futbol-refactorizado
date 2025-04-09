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

*Impementamos el token al una* **variable de entorno** *para aislarla del codigo:*

```
set SONAR_TOKEN=sqa_01714030258bbcdde6974160a17915fb6b85b5e4
```

## HIGH

1. File path "\Users\Usuario\Desktop\GIT\gestor-futbol-refactorizado" should match package name "practica_refactorizacion_casa". Move the file or change the package name.

*Renombrar la carpeta del proyecto de "gestor-futbol-refactorizado" a* **practica_refactorizacion_casa**


2. Refactor this method to reduce its Cognitive Complexity from 18 to the 15 allowed.

*Fácilmente obtenible descomponiendo las funcionalidades del método original en métodos más pequeños*


## MEDIUM // LOW

1. Varias de esta issues eran solucionables mediante la eliminación, en caso de no ser variables o elementos usados, o bajo una leve modificación para adaptar su sintaxis al resto del código.


2. Cambio de SYSO a Logger, el cual debe declararse previo al main como una variable privada, estática y final (constante):
```
System.out.println();
```

```
private static final Logger logger = Logger.getLogger(GestorFutbol.class.getName());
logger.info();
```

3. Sobrescribir el método hashCode()
```
@Override
    public int hashCode() {
        return Objects.hash(equipoNombre);
    }
```

4. Modificar el método compareTo(GestorFutbol otro) para que devuelva -1