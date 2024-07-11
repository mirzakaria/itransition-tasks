a=process.argv.slice(2)
s=a[0]||'';for(l=s.length;~l;l--)
for(x=0;x<=s.length-l;x++){t=s.slice(x,x+l)
f=true;for(i=0;i<a.length;i++)
if(!a[i].includes(t))f=false
if(f){console.log(t);return}}