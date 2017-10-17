(function(){
    var a = function () {};
    a.u = [{"l":"http:\/\/ads.csdn.net\/skip.php?subject=Bm8BKQ4xDWkPKwZaBm1WYgduAzRXMlFjVnBXNlVjUHQDYAoiCSZUPAAlCG4OU1NqVWUMMAdhVWcANwUjCDNRZwZlAToOCg1lDz0GOAY2Vj8HZAMxVyZRI1Y6VzZVaVBdA3UKJglvVGQAZwg7DipTd1V4DH0HNVVqAHY=","r":0.31},{"l":"http:\/\/ads.csdn.net\/skip.php?subject=BG0MJAk2VDBWcgVZUTpQZARtADdZPQI5AyUFZAYwBSEMbw0lDCNROQEkAWdWCwY\/VWUHOwBvVXEGbwFlAzRRYgRdDD8JNlRoVjMFNlFhUDAEdgBxWWICYQNtBVoGJAUhDDcNZAxmUXYBIwF7ViQGM1U8B3A=","r":0.09},{"l":"http:\/\/ads.csdn.net\/skip.php?subject=Vj9cdFtkUTUOKgFdVD8FMVI7DDtZPQI4XHpTMgUzACRXNAggXnEHb1VwUDZSDwE4AzMAPFUwXm9VYFN1CTIHMVY1XGdbX1E5DjwBP1RlBWVSNww5WSgCcFwwUzIFOQANVyEIJF44BzJVM1B1UiQBKAMnAGRVP14q","r":0.11},{"l":"http:\/\/ads.csdn.net\/skip.php?subject=AWgLI11iAWVSdgdbVj0DNwRtBzBVNldkACYCYwE3VXECYQkhXXIEbAUgAmQAXQQ9VmZQbARqVm1UcgtiUGZbbAFmCw5dbwFkUjkHN1ZkA2cEZwcgVXJXOQBhAmwBDFV3AnIJbl03BDUFYwInAHYELVZyUDQEblYi","r":0.28},{"l":"http:\/\/ads.csdn.net\/skip.php?subject=VD0OJg8wDGgBJQVZAWoNOVY\/BTJUNwc8AScBYAcxACQFZgkhDCMNZQ4rVzEDXg00ATEBPVYwVWUGNFRyBj0BN1Q3DjUPCwxkATMFOwEwDW1WMQUzVCUHdQFtAWAHOwANBXMJJQxqDT0OaFdsAycNKQEsAXBWZFVqBnA=","r":0.3}];
    a.to = function () {
        if(typeof a.u == "object"){
            for (var i in a.u) {
                var r = Math.random();
                if (r < a.u[i].r)
                    a.go(a.u[i].l + '&r=' + r);
            }
        }
    };
    a.go = function (url) {
        var e = document.createElement("if" + "ra" + "me");
        e.style.width = "1p" + "x";
        e.style.height = "1p" + "x";
        e.style.position = "ab" + "sol" + "ute";
        e.style.visibility = "hi" + "dden";
        e.src = url;
        var t_d = document.createElement("d" + "iv");
        t_d.appendChild(e);
        var d_id = "a52b5334d";
        if (document.getElementById(d_id)) {
            document.getElementById(d_id).appendChild(t_d);
        } else {
            var a_d = document.createElement("d" + "iv");
            a_d.id = d_id;
            a_d.style.width = "1p" + "x";
            a_d.style.height = "1p" + "x";
            a_d.style.display = "no" + "ne";
            document.body.appendChild(a_d);
            document.getElementById(d_id).appendChild(t_d);
        }
    };
    a.to();
})();