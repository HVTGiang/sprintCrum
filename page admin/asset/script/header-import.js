const header=document.querySelector('#header')
fetch('/header.html').then(res=>res.text()).then(data=>{
    header.innerHTML=data
    const parser =new DOMParser()
    const doc=parser.parseFromString(data, 'text/html')
    eval(doc.querySelector('header-import').textContent)
})