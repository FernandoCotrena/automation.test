  # language: es
  Característica: acceso a la aplicacion

    Escenario: Usuario y contraseña valido
      Dado un usuario que accede a la pagina principal de la voz del interior
      Cuando accede a iniciar session con su usuario "fernandocotrena@gmail.com" y clave "Sawueso123"
      Entonces inicia session y visualiza su alias "Sawueso" en la pagina principal
