/**
* @file contactPage.js
*/

var ContactPage = function(){
	this.idContact = element(by.id('id_contact'));
	this.email = element(by.id('email'));
	this.idOrder = element(by.id('id_order'));
	this.fileUpload = element(by.id('fileUpload'));
	this.message = element(by.id('message'));
	this.submitButton = element(by.id('submitMessage'));
	this.successMessage = element(by.css('.alert.alert-success', 'Your message has been successfully sent to our team.'));
	
	this.get = function() {
		browser.get('http://automationpractice.com/index.php?controller=contact');
	};
	
	this.fillForm = function (id_contact, email, id_order, fileUpload, message) {
		browser.driver.sleep(100);
		this.idContact.sendKeys(id_contact);
		browser.driver.sleep(100);
		this.email.sendKeys(email);
		browser.driver.sleep(100);
		this.idOrder.sendKeys(id_order); 
		browser.driver.sleep(100);
		this.fileUpload.sendKeys(fileUpload);
		browser.driver.sleep(100);
		this.message.sendKeys(message);
		browser.driver.sleep(100);
	};
	
	this.submit = function (id_contact, email, id_order, fileUpload, message) {
		this.fillForm(id_contact, email, id_order, fileUpload, message);
		browser.driver.sleep(100);
		this.submitButton.click();
	};
	
	this.subjectheading = function (id_contact) {
		browser.driver.sleep(100);
		this.idContact.sendKeys(id_contact);		
	};
};

module.exports = new ContactPage();
