const menu=document.querySelector('#menu')
fetch('/menu.html').then(res=>res.text()).then(data=>{
    menu.innerHTML=data
    const parser =new DOMParser()
    const doc=parser.parseFromString(data, 'text/html')
    eval(doc.querySelector('menu-import').textContent)
})