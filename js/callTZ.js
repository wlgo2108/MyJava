/**
 * 
 */
function changeInfo() {
		with (myForm) {
			var serverNames = new Array() ;
			
			serverNames["0"] = ["--请选择游戏--"] ;
			serverNames["SC"] = ["B001","QL730","3D","K512"]
			serverNames["GS"] = ["B001","QL730","3D","K3"]
			var value = server_name.value ;
			
			var proCode = "0" ;
			if(isContains(value,"四川")) {
				proCode = "SC" ;
			} else if (isContains(value,"甘肃")) {
				proCode = "GS" ;
			}
			var option;
			
			game.options.length = 0;  //这个代码是很关键的代码，代码将select 的option个数为0个 
			for (i = 0; i < serverNames[proCode].length; i++) {

				option = new Option(getGameName(serverNames[proCode][i]),
						serverNames[proCode][i]);
				game.options.add(option);
			}
			setStationID(proCode) ;
			
			if (proCode == "0") {
				game.disabled = true;
				document.getElementById("station_id").value = "" ;

			} else {
				game.disabled = false;
			}
			
		
		}
	}
	
	
	function isContains(str, substr) {
	    return str.indexOf(substr) >= 0;
	}
	
	function getGameName(game) {
		if (game == "B001") {
			return ("双色球");
		} else if (game == "QL730") {
			return ("七乐彩");
		} else if (game == "3D") {
			return ("3D");
		} else if (game == "K3") {
			return ("快三");
		} else if (game == "K512") {
			return ("快乐十二");
		} else if (game == "SSC") {
			return ("时时彩");
		} else {
			return ("--请选择游戏--");
		}
	}
	
	function setStationID(proCode) {
		
		switch (proCode) {
		case "SC":
			document.getElementById("station_id").value = "51010005" ;
			break;
		case "GS":
			document.getElementById("station_id").value = "62011005" ;
			break;
		case "XJ":
			document.getElementById("station_id").value = "64010005" ;
			break;
		default:
			return ("");
		}
	}
	
	function changeStat() {
		with(myForm) {
			var statValue = stat.value  ;
			if(statValue == "7") {
				document.getElementById("tsn_p").style="display:none" ;
				document.getElementById("issue_p").style="display:none" ;
				document.getElementById("money_p").style="display:block"
				
			} else {
				document.getElementById("tsn_p").style="display:block" ;
				document.getElementById("issue_p").style="display:block" ;
				document.getElementById("money_p").style="display:none"
			}
			
		}
	}