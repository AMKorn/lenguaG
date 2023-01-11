	extern printf
	section .data
t0: 	times 80 db 0
t8: 	times 4 db 0
t7: 	times 4 db 0
t6: 	times 4 db 0
t5: 	times 4 db 0
t4: 	times 4 db 0
t3: 	times 4 db 0
t2: 	times 4 db 0
t1: 	times 4 db 0
fmtOutInt: db "%d",10,0
fmtOutChar: db "%s",10,0
	section .text
	global main
main:
	mov rbp,rsp
	push rbp

	; 	t0[0] = 0
	mov rax,t0
	add rax,0
	mov ebx,0
	mov [rax],ebx
	; 	t0[4] = 1
	mov rax,t0
	add rax,4
	mov ebx,1
	mov [rax],ebx
	; 	t0[8] = 2
	mov rax,t0
	add rax,8
	mov ebx,2
	mov [rax],ebx
	; 	t0[12] = 3
	mov rax,t0
	add rax,12
	mov ebx,3
	mov [rax],ebx
	; 	t0[16] = 4
	mov rax,t0
	add rax,16
	mov ebx,4
	mov [rax],ebx
	; 	t0[20] = 5
	mov rax,t0
	add rax,20
	mov ebx,5
	mov [rax],ebx
	; 	t0[24] = 6
	mov rax,t0
	add rax,24
	mov ebx,6
	mov [rax],ebx
	; 	t0[28] = 7
	mov rax,t0
	add rax,28
	mov ebx,7
	mov [rax],ebx
	; 	t0[32] = 8
	mov rax,t0
	add rax,32
	mov ebx,8
	mov [rax],ebx
	; 	t0[36] = 9
	mov rax,t0
	add rax,36
	mov ebx,9
	mov [rax],ebx
	; 	t0[40] = 10
	mov rax,t0
	add rax,40
	mov ebx,10
	mov [rax],ebx
	; 	t0[44] = 11
	mov rax,t0
	add rax,44
	mov ebx,11
	mov [rax],ebx
	; 	t0[48] = 12
	mov rax,t0
	add rax,48
	mov ebx,12
	mov [rax],ebx
	; 	t0[52] = 13
	mov rax,t0
	add rax,52
	mov ebx,13
	mov [rax],ebx
	; 	t0[56] = 14
	mov rax,t0
	add rax,56
	mov ebx,14
	mov [rax],ebx
	; 	t0[60] = 15
	mov rax,t0
	add rax,60
	mov ebx,15
	mov [rax],ebx
	; 	t0[64] = 16
	mov rax,t0
	add rax,64
	mov ebx,16
	mov [rax],ebx
	; 	t0[68] = 17
	mov rax,t0
	add rax,68
	mov ebx,17
	mov [rax],ebx
	; 	t0[72] = 18
	mov rax,t0
	add rax,72
	mov ebx,18
	mov [rax],ebx
	; 	t0[76] = 19
	mov rax,t0
	add rax,76
	mov ebx,19
	mov [rax],ebx
	; e0: skip
e0:
	; 	pmb main
	; 	t1 = 0 * 2
	mov eax,0
	mov ecx,2
	mul ecx
	mov [t1],eax
	; 	t2 = 2
	mov eax,2
	mov [t2],eax
	; 	t3 = t1 + t2
	mov eax,[t1]
	mov ebx,[t2]
	add ebx,eax
	mov [t3],ebx
	; 	t4 = t3 * 10
	mov eax,[t3]
	mov ecx,10
	mul ecx
	mov [t4],eax
	; 	t5 = 2
	mov eax,2
	mov [t5],eax
	; 	t6 = t4 + t5
	mov eax,[t4]
	mov ebx,[t5]
	add ebx,eax
	mov [t6],ebx
	; 	t7 = t6 * 4
	mov eax,[t6]
	mov ecx,4
	mul ecx
	mov [t7],eax
	; 	t8 = t0[t7]
	mov rax,t0
	add rax,[t7]
	mov eax,[rax]
	mov [t8],eax
	; 	out: t8
	mov rdi,fmtOutInt
	mov rsi,[t8]
	mov rax, 0
	call printf

	pop rbp
	mov rax,0
	ret
