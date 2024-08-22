import pygame
import time
import random

# Inicializar pygame
pygame.init()

# Definir los colores
blanco = (255, 255, 255)
amarillo = (255, 255, 102)
negro = (0, 0, 0)
verde = (0, 255, 0)
rojo = (213, 50, 80)

# Definir el tamaño de la ventana
ancho_ventana = 600
alto_ventana = 400

# Crear la ventana
ventana = pygame.display.set_mode((ancho_ventana, alto_ventana))
pygame.display.set_caption('Juego de la Serpiente')

# Definir la velocidad de la serpiente
reloj = pygame.time.Clock()
velocidad_serpiente = 15

# Tamaño del bloque de la serpiente
tamaño_bloque = 10

# Fuente del texto
fuente = pygame.font.SysFont(None, 35)

def mensaje(msg, color):
    texto = fuente.render(msg, True, color)
    ventana.blit(texto, [ancho_ventana / 6, alto_ventana / 3])

def juego():
    juego_terminado = False
    juego_cerrado = False

    # Posición inicial de la serpiente
    x1 = ancho_ventana / 2
    y1 = alto_ventana / 2

    # Cambios en la posición
    cambio_x = 0
    cambio_y = 0

    # Dirección actual
    direccion = None

    # Longitud inicial de la serpiente
    serpiente = []
    longitud_serpiente = 1

    # Posición de la comida
    comida_x = round(random.randrange(0, ancho_ventana - tamaño_bloque) / 10.0) * 10.0
    comida_y = round(random.randrange(0, alto_ventana - tamaño_bloque) / 10.0) * 10.0

    while not juego_terminado:

        while juego_cerrado:
            ventana.fill(negro)
            mensaje("¡Perdiste! Presiona Q para salir o C para jugar nuevamente", rojo)
            pygame.display.update()

            for evento in pygame.event.get():
                if evento.type == pygame.KEYDOWN:
                    if evento.key == pygame.K_q:
                        juego_terminado = True
                        juego_cerrado = False
                    if evento.key == pygame.K_c:
                        juego()

        for evento in pygame.event.get():
            if evento.type == pygame.QUIT:
                juego_terminado = True
            if evento.type == pygame.KEYDOWN:
                if evento.key == pygame.K_LEFT and direccion != 'RIGHT':
                    cambio_x = -tamaño_bloque
                    cambio_y = 0
                    direccion = 'LEFT'
                elif evento.key == pygame.K_RIGHT and direccion != 'LEFT':
                    cambio_x = tamaño_bloque
                    cambio_y = 0
                    direccion = 'RIGHT'
                elif evento.key == pygame.K_UP and direccion != 'DOWN':
                    cambio_y = -tamaño_bloque
                    cambio_x = 0
                    direccion = 'UP'
                elif evento.key == pygame.K_DOWN and direccion != 'UP':
                    cambio_y = tamaño_bloque
                    cambio_x = 0
                    direccion = 'DOWN'

        if x1 >= ancho_ventana or x1 < 0 or y1 >= alto_ventana or y1 < 0:
            juego_cerrado = True
        x1 += cambio_x
        y1 += cambio_y
        ventana.fill(negro)
        pygame.draw.rect(ventana, rojo, [comida_x, comida_y, tamaño_bloque, tamaño_bloque])
        serpiente_cabeza = []
        serpiente_cabeza.append(x1)
        serpiente_cabeza.append(y1)
        serpiente.append(serpiente_cabeza)
        if len(serpiente) > longitud_serpiente:
            del serpiente[0]

        for segmento in serpiente[:-1]:
            if segmento == serpiente_cabeza:
                juego_cerrado = True

        for segmento in serpiente:
            pygame.draw.rect(ventana, verde, [segmento[0], segmento[1], tamaño_bloque, tamaño_bloque])

        pygame.display.update()

        if x1 == comida_x and y1 == comida_y:
            comida_x = round(random.randrange(0, ancho_ventana - tamaño_bloque) / 10.0) * 10.0
            comida_y = round(random.randrange(0, alto_ventana - tamaño_bloque) / 10.0) * 10.0
            longitud_serpiente += 1

        reloj.tick(velocidad_serpiente)

    pygame.quit()
    quit()

juego()
