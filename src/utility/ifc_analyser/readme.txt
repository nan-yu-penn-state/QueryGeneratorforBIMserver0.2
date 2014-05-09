 Author Hsyao Liu
 Pennsylvania State University

*********************************************************************

 IFC Analyser : This tool serves to build a hierachical analysis for 
 each IFC entity. 

 For example, in 101.ifc which is the IFC file for building 101, you 
 may find #125=IFCWALLSTANDARDCASE('0ouhTGHJ12F8wlY1Mn$fhQ',#1,
 'Basic Wall:Generic -18":190703',$,'Basic Wall:Generic -18":157872',
 #188,#61645,'190703') at line 132. 
 To analyse the "IFCWALLSTANDARDCASE", you may first compile the 
 java code, you may type in the terminal by (without dash -):
 
 - javac Hierachical_IFC.java

 Then, you can execute by type in the terminal (without dash -):

 - java Hierachical_IFC ifc_file_name.ifc number

 you should put the correct and valid ifc file name with the .ifc 
 as the first input argument and the number is the number after #
 of the entity you are going to analyse.

 Goes with the example, you may get the following as a result:

 *********************************************************************

#125=IFCWALLSTANDARDCASE('0ouhTGHJ12F8wlY1Mn$fhQ',#1,'Basic Wall:Generic -18":190703',$,'Basic Wall:Generic -18":157872',#188,#61645,'190703');
	#1=IFCOWNERHISTORY(#59339,#33646,$,.NOCHANGE.,$,$,$,1370010441);
		#59339=IFCPERSONANDORGANIZATION(#31508,#31507,$);
			#31508=IFCPERSON($,'Xu_PSUAE','Ke',$,$,$,$,$);
			#31507=IFCORGANIZATION($,'','',$,$);
		#33646=IFCAPPLICATION(#31506,'2014','Autodesk Revit 2014 (ENU)','Revit');
			#31506=IFCORGANIZATION($,'Autodesk Revit 2014 (ENU)',$,$,$);
	#188=IFCLOCALPLACEMENT(#34,#34534);
		#34=IFCLOCALPLACEMENT(#1664,#34326);
			#1664=IFCLOCALPLACEMENT(#17307,#3);
				#17307=IFCLOCALPLACEMENT($,#65188);
					#65188=IFCAXIS2PLACEMENT3D(#224,#2,#31503);
						#224=IFCCARTESIANPOINT((0.0,0.0,0.0));
						#2=IFCDIRECTION((0.0,0.0,1.0));
						#31503=IFCDIRECTION((-0.063136802128652,0.998004881860288,0.0));
				#3=IFCAXIS2PLACEMENT3D(#224,$,$);
					#224=IFCCARTESIANPOINT((0.0,0.0,0.0));
			#34326=IFCAXIS2PLACEMENT3D(#21336,$,$);
				#21336=IFCCARTESIANPOINT((0.0,0.0,26.2916666666678));
		#34534=IFCAXIS2PLACEMENT3D(#26870,$,$);
			#26870=IFCCARTESIANPOINT((-231.617435617374,37.1243959027349,0.0));
	#61645=IFCPRODUCTDEFINITIONSHAPE($,$,(#18245,#18246));
		#18245=IFCSHAPEREPRESENTATION(#15,'Axis','Curve2D',(#12194));
			#15=IFCGEOMETRICREPRESENTATIONSUBCONTEXT('Axis','Model',*,*,*,*,#1392,$,.GRAPH_VIEW.,$);
				#1392=IFCGEOMETRICREPRESENTATIONCONTEXT($,'Model',3,1.0E-9,#3,#14700);
					#3=IFCAXIS2PLACEMENT3D(#224,$,$);
						#224=IFCCARTESIANPOINT((0.0,0.0,0.0));
					#14700=IFCDIRECTION((2.0,0.998004881860288,-0.0631368021286521));
			#12194=IFCPOLYLINE((#5,#3791));
				#5=IFCCARTESIANPOINT((0.0,0.0));
				#3791=IFCCARTESIANPOINT((234.0,0.0));
		#18246=IFCSHAPEREPRESENTATION(#4,'Body','SweptSolid',(#20123));
			#4=IFCGEOMETRICREPRESENTATIONSUBCONTEXT('Body','Model',*,*,*,*,#1392,$,.MODEL_VIEW.,$);
				#1392=IFCGEOMETRICREPRESENTATIONCONTEXT($,'Model',3,1.0E-9,#3,#14700);
					#3=IFCAXIS2PLACEMENT3D(#224,$,$);
						#224=IFCCARTESIANPOINT((0.0,0.0,0.0));
					#14700=IFCDIRECTION((2.0,0.998004881860288,-0.0631368021286521));
			#20123=IFCEXTRUDEDAREASOLID(#55779,#3,#2,15.0);
				#55779=IFCRECTANGLEPROFILEDEF(.AREA.,$,#56436,234.0,1.5);
					#56436=IFCAXIS2PLACEMENT2D(#26871,#26);
						#26871=IFCCARTESIANPOINT((117.0,3.88578058618805E-16));
						#26=IFCDIRECTION((-1.0,0.0));
				#3=IFCAXIS2PLACEMENT3D(#224,$,$);
					#224=IFCCARTESIANPOINT((0.0,0.0,0.0));
				#2=IFCDIRECTION((0.0,0.0,1.0));
 *********************************************************************
 




