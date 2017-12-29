var login_page = function () {

	this.correctLogin = function(username, password){
		var usernameTerm = username;
		for(i = 0; i < usernameTerm.length; i++){
			element(by.id('username')).sendKeys(usernameTerm.charAt(i));
		}

		var passwordTerm = password;
		for(i = 0; i < passwordTerm.length; i++){
			element(by.id('password')).sendKeys(passwordTerm.charAt(i));
		}
		element(by.buttonText("Aanmelden")).click();
	};
	
};
module.exports = new login_page();