[![Build Status](https://travis-ci.org/programacion-avanzada/cronometro.svg?branch=master)](https://travis-ci.org/programacion-avanzada/cronometro)

# Cronometro

`Cronometro` otorga la funcionalidad para medir tiempos en procesos, para luego realizar informes.

## Ejemplos de uso

```java
Cronometro crono = new Cronometro(Precision.SEGUNDOS);
crono.clic("burbujeo");
arreglo.ordenarPorBurbujeo();
crono.clic("burbujeo");
arreglo.desordenar();
crono.clic("insercion");
arreglo.ordenarPorInsercion();
crono.clic("insercion");

System.out.println(crono.getMediciones("burbujeo").getTotal());
System.out.println(crono.getMediciones("insercion").getTotal());
```

## Contribuciones

1. Hacer un fork
2. Crear un feature-branch (`git checkout -b my-new-feature`)
3. Commitear los cambios (`git commit -am 'Add some feature'`)
4. Hacer push al branch (`git push origin my-new-feature`)
5. Crear un Pull Request