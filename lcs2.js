a=process.argv.slice(2);
s=a[0]||'';r="";
for(i=0;i<s.length;i++)for(j=i+1;j<=s.length;j++){
t=s.substring(i,j);let k;for(k=1;k<a.length;k++)
if(!a[k].includes(t))break;if(k==a.length&&r.length<t.length)r=t;}
console.log(r)