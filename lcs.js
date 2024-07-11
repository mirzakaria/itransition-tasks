const arguments = process.argv
function lcs(args) {
    let res = "";
    if(args.length == 2) return res;

    let s = args[2];
    for (let i = 0; i < s.length; i++) {
	    for (let j = i + 1; j <= s.length; j++) {
		    let stem = s.substring(i, j);
            let k;
		    for (k = 3; k < args.length; k++) {
			    if (!args[k].includes(stem)) break;
		    }
		    if (k === args.length && res.length < stem.length)
			    res = stem;
	    }
    }
    return res;
}

console.log(lcs(arguments))