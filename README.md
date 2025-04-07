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


