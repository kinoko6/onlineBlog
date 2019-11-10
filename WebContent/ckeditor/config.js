/**
 * @license Copyright (c) 2003-2017, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see LICENSE.md or http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function( config ) {
	// Define changes to default configuration here.
	// For complete reference see:
	// http://docs.ckeditor.com/#!/api/CKEDITOR.config

	// The toolbar groups arrangement, optimized for two toolbar rows.
	config.toolbarGroups = [
		{ name: 'clipboard',   groups: [ 'clipboard', 'undo' ] },
		{ name: 'editing',     groups: [ 'find', 'selection', 'spellchecker' ] },
		{ name: 'links' },
		{ name: 'insert' },
		{ name: 'forms' },
		{ name: 'tools' },
		{ name: 'document',	   groups: [ 'mode', 'document', 'doctools' ] },
		{ name: 'others' },
		{ name: 'justify',	 groups: [ 'AlignLeft', 'AlignCenter', 'AlignRight', 'AlignJustify' ] },
		{ name: 'basicstyles', groups: [ 'basicstyles', 'cleanup' ] },
		{ name: 'paragraph',   groups: [ 'list', 'indent', 'blocks', 'align', 'bidi' ] },
		{ name: 'styles' },
		{ name: 'colors' }
	];

	// Remove some buttons provided by the standard plugi	ns, which are
	// not needed in the Standard(s) toolbar.
	config.removeButtons = 'Underline,Subscript,Superscript';
	

	// Set the most common block elements.
	config.format_tags = 'p;h1;h2;h3;pre';
	config.image_previewText=' '; 
	
	// Simplify the dialog windows.
	config.removeDialogTabs = 'image:advanced;link:advanced';
	
	config.filebrowserUploadUrl="uploadImage";
	config.smiley_columns = 8;
    codeSnippet_theme: 'zenburn';
	config.extraPlugins = 'lineutils,dialog,widget,colorbutton,panelbutton,justify,smiley,font,balloontoolbar,balloonpanel,lineheight,autogrow,textmatch,autocomplete,xml,ajax,textwatcher,preview,floatpanel';
};
