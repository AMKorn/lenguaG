	section .data
t1: 	times 4 db 0
t0: 	times 4 db 0
t4: 	times 20 db 0
t3: 	times 8 db 0
t2: 	times 4 db 0
	section .text
	global main
main:
	push rbp
	pop rbp
	mov rax,0
ret
