================================================================================
    MFC Freeway Project Overview
===============================================================================

The application wizard has created this Freeway application for
you.  This application not only demonstrates the basics of using the Microsoft
Foundation Classes but is also a starting point for writing your application.

This file contains a summary of what you will find in each of the files that
make up your Freeway application.

Freeway.vcxproj
    This is the main project file for VC++ projects generated using an application wizard.
    It contains information about the version of Visual C++ that generated the file, and
    information about the platforms, configurations, and project features selected with the
    application wizard.

Freeway.vcxproj.filters
    This is the filters file for VC++ projects generated using an Application Wizard. 
    It contains information about the association between the files in your project 
    and the filters. This association is used in the IDE to show grouping of files with
    similar extensions under a specific node (for e.g. ".cpp" files are associated with the
    "Source Files" filter).

FreewayApp.h
    This is the main header file for the application.  It includes other
    project specific headers (including Resource.h) and declares the
    CFreewayApp application class.

FreewayApp.cpp
    This is the main application source file that contains the application
    class CFreewayApp.

Freeway.rc
    This is a listing of all of the Microsoft Windows resources that the
    program uses.  It includes the icons, bitmaps, and cursors that are stored
    in the RES subdirectory.  This file can be directly edited in Microsoft
    Visual C++. Your project resources are in 1033.

res\Freeway.ico
    This is an icon file, which is used as the application's icon.  This
    icon is included by the main resource file Freeway.rc.

res\Freeway.rc2
    This file contains resources that are not edited by Microsoft
    Visual C++. You should place all resources not editable by
    the resource editor in this file.

Freeway.reg
    This is an example .reg file that shows you the kind of registration
    settings the framework will set for you.  You can use this as a .reg
    file to go along with your application or just delete it and rely
    on the default RegisterShellFileTypes registration.


/////////////////////////////////////////////////////////////////////////////

For the main frame window:
    The project includes a standard MFC interface.

MainFrm.h, MainFrm.cpp
    These files contain the frame class CMainFrame, which is derived from
    CFrameWnd and controls all SDI frame features.

res\Toolbar.bmp
    This bitmap file is used to create tiled images for the toolbar.
    The initial toolbar and status bar are constructed in the CMainFrame
    class. Edit this toolbar bitmap using the resource editor, and
    update the IDR_MAINFRAME TOOLBAR array in Freeway.rc to add
    toolbar buttons.
/////////////////////////////////////////////////////////////////////////////

The application wizard creates one document type and one view:

FreewayDoc.h, FreewayDoc.cpp - the document
    These files contain your CFreewayDoc class.  Edit these files to
    add your special document data and to implement file saving and loading
    (via CFreewayDoc::Serialize).
    The Document will have the following strings:
        File extension:      sim
        File type ID:        Freeway.Document
        Main frame caption:  Freeway
        Doc type name:       Freeway
        Filter name:         Freeway Files (*.sim)
        File new short name: Freeway
        File type long name: Freeway.Document

FreewayView.h, FreewayView.cpp - the view of the document
    These files contain your CFreewayView class.
    CFreewayView objects are used to view CFreewayDoc objects.

/////////////////////////////////////////////////////////////////////////////

Other Features:

Printing and Print Preview support
    The application wizard has generated code to handle the print, print setup, and print preview
    commands by calling member functions in the CView class from the MFC library.

/////////////////////////////////////////////////////////////////////////////

Other standard files:

StdAfx.h, StdAfx.cpp
    These files are used to build a precompiled header (PCH) file
    named Freeway.pch and a precompiled types file named StdAfx.obj.

Resource.h
    This is the standard header file, which defines new resource IDs.
    Microsoft Visual C++ reads and updates this file.

Freeway.manifest
	Application manifest files are used by Windows XP to describe an applications
	dependency on specific versions of Side-by-Side assemblies. The loader uses this
	information to load the appropriate assembly from the assembly cache or private
	from the application. The Application manifest  maybe included for redistribution
	as an external .manifest file that is installed in the same folder as the application
	executable or it may be included in the executable in the form of a resource.
/////////////////////////////////////////////////////////////////////////////

Other notes:

The application wizard uses "TODO:" to indicate parts of the source code you
should add to or customize.

If your application uses MFC in a shared DLL, you will need
to redistribute the MFC DLLs. If your application is in a language
other than the operating system's locale, you will also have to
redistribute the corresponding localized resources mfc110XXX.DLL.
For more information on both of these topics, please see the section on
redistributing Visual C++ applications in MSDN documentation.

/////////////////////////////////////////////////////////////////////////////

Freeway.h / Freeway.cpp
	Definiert den simulierten Autobahnabschnitt. Die L�nge, die Anzahl Spuren, die Sektorl�nge.
	Definiert zudem die Sektoren, welche infolge Bauarbeiten gesperrt sind.

Simulation.h / Simulation.cpp
	Steuerung der Simulation. Simulation starten, pausieren, stoppen. Simulationsparameter setzen.
	Verwaltet die Autos, das Parking und die Autobahn.

Units.h
	Definiert die verwendeten Standardeinheiten f�r Zeit (Sekunden, Minuten, Stunden), 
	Distanz (Meter, Kilometer) und Geschwindigkeit (m/s und km/h).

PropertiesWnd.h / PropertiesWnd.cpp
	Definiert und implementiert ein Property-Grid-Fenster zur Ein- und Ausgabe von Simulationsparametern.

/////////////////////////////////////////////////////////////////////////////
Anpassungen/Erg�nzungen im Unterricht:

Parking.h
	Definiert und implementiert einen Parkplatz f�r die Autos, welche die Simulation verlassen haben. Dadurch
	kann verhindert werden, dass st�ndig neue Autos erzeugt werden m�ssen. Bevor also ein 
	neues Auto erzeugt wird, sollte das Parking angefragt werden, ob es dort bereits ein 
	verf�gbares Auto gibt. Das Parking wird als einfach-verkn�pfte Liste von unique_ptr<Car>
	realisiert. Es sollen die Methoden parkCar(unique_ptr<Car>&& c) und getCar() angeboten 
	werden.

Car.h
	Definiert und implementiert im Wesentlichen die Klasse Car. Ein Auto soll die Attribute Farbe, Position, 
	Geschwindigkeitsfaktor und den Zeitpunkt beim Erscheinen im simulierten Autobahnabschnitt besitzen. 
	Zudem soll mit einer Klassenvariable die Farbe des n�chsten Autos bestimmt werden.

Cars.h / Cars.cpp
	Verwaltet die Autos im simulierten Autobahnabschnitt in einer doppelt-verketteten Liste.
	Die Reihenfolge der Autos in der Liste entspricht der zunehmenden aktuellen Position. Haben mehrere
	Autos die gleiche Position, so m�ssen sie sich auf unterschiedlichen Spuren befinden.	

/////////////////////////////////////////////////////////////////////////////