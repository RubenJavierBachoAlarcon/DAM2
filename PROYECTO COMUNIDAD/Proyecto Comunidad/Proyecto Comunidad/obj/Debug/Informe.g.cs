<<<<<<<< HEAD:PROYECTO COMUNIDAD/Proyecto Comunidad/Proyecto Comunidad/obj/Debug/Informe.g.cs
﻿#pragma checksum "..\..\Informe.xaml" "{8829d00f-11b8-4213-878b-770e8597ac16}" "53C12544C7106713566507AD2F55DE3053265C3B7BE5D4E997AB65D511DB3EA7"
========
﻿#pragma checksum "..\..\CommunityInfo.xaml" "{8829d00f-11b8-4213-878b-770e8597ac16}" "48C32578B49F9F77BB0C1BC0AA6D03675FD92021BCDF5AE188BE3792CC975839"
>>>>>>>> Interfaz:PROYECTO COMUNIDAD/Proyecto Comunidad/Proyecto Comunidad/obj/Debug/CommunityInfo.g.cs
//------------------------------------------------------------------------------
// <auto-generated>
//     Este código fue generado por una herramienta.
//     Versión de runtime:4.0.30319.42000
//
//     Los cambios en este archivo podrían causar un comportamiento incorrecto y se perderán si
//     se vuelve a generar el código.
// </auto-generated>
//------------------------------------------------------------------------------

using FontAwesome.Sharp;
using Proyecto_Comunidad;
using RootLibrary.WPF.Localization;
using SAPBusinessObjects.WPF.Viewer;
using System;
using System.Diagnostics;
using System.Windows;
using System.Windows.Automation;
using System.Windows.Controls;
using System.Windows.Controls.Primitives;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Ink;
using System.Windows.Input;
using System.Windows.Markup;
using System.Windows.Media;
using System.Windows.Media.Animation;
using System.Windows.Media.Effects;
using System.Windows.Media.Imaging;
using System.Windows.Media.Media3D;
using System.Windows.Media.TextFormatting;
using System.Windows.Navigation;
using System.Windows.Shapes;
using System.Windows.Shell;


namespace Proyecto_Comunidad {
    
    
    /// <summary>
<<<<<<<< HEAD:PROYECTO COMUNIDAD/Proyecto Comunidad/Proyecto Comunidad/obj/Debug/Informe.g.cs
    /// Informe
    /// </summary>
    public partial class Informe : System.Windows.Window, System.Windows.Markup.IComponentConnector {
        
        
        #line 124 "..\..\Informe.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.StackPanel pnlControlBar;
========
    /// CommunityInfo
    /// </summary>
    public partial class CommunityInfo : System.Windows.Window, System.Windows.Markup.IComponentConnector {
        
        
        #line 14 "..\..\CommunityInfo.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal SAPBusinessObjects.WPF.Viewer.CrystalReportsViewer crystalReportsViewer;
>>>>>>>> Interfaz:PROYECTO COMUNIDAD/Proyecto Comunidad/Proyecto Comunidad/obj/Debug/CommunityInfo.g.cs
        
        #line default
        #line hidden
        
        private bool _contentLoaded;
        
        /// <summary>
        /// InitializeComponent
        /// </summary>
        [System.Diagnostics.DebuggerNonUserCodeAttribute()]
        [System.CodeDom.Compiler.GeneratedCodeAttribute("PresentationBuildTasks", "4.0.0.0")]
        public void InitializeComponent() {
            if (_contentLoaded) {
                return;
            }
            _contentLoaded = true;
<<<<<<<< HEAD:PROYECTO COMUNIDAD/Proyecto Comunidad/Proyecto Comunidad/obj/Debug/Informe.g.cs
            System.Uri resourceLocater = new System.Uri("/Proyecto Comunidad;component/informe.xaml", System.UriKind.Relative);
            
            #line 1 "..\..\Informe.xaml"
========
            System.Uri resourceLocater = new System.Uri("/Proyecto Comunidad;component/communityinfo.xaml", System.UriKind.Relative);
            
            #line 1 "..\..\CommunityInfo.xaml"
>>>>>>>> Interfaz:PROYECTO COMUNIDAD/Proyecto Comunidad/Proyecto Comunidad/obj/Debug/CommunityInfo.g.cs
            System.Windows.Application.LoadComponent(this, resourceLocater);
            
            #line default
            #line hidden
        }
        
        [System.Diagnostics.DebuggerNonUserCodeAttribute()]
        [System.CodeDom.Compiler.GeneratedCodeAttribute("PresentationBuildTasks", "4.0.0.0")]
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Never)]
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Design", "CA1033:InterfaceMethodsShouldBeCallableByChildTypes")]
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Maintainability", "CA1502:AvoidExcessiveComplexity")]
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1800:DoNotCastUnnecessarily")]
        void System.Windows.Markup.IComponentConnector.Connect(int connectionId, object target) {
            switch (connectionId)
            {
            case 1:
<<<<<<<< HEAD:PROYECTO COMUNIDAD/Proyecto Comunidad/Proyecto Comunidad/obj/Debug/Informe.g.cs
            this.pnlControlBar = ((System.Windows.Controls.StackPanel)(target));
            
            #line 130 "..\..\Informe.xaml"
            this.pnlControlBar.MouseLeftButtonDown += new System.Windows.Input.MouseButtonEventHandler(this.pnlControlBar_MouseLeftButtonDown);
            
            #line default
            #line hidden
            
            #line 131 "..\..\Informe.xaml"
            this.pnlControlBar.MouseEnter += new System.Windows.Input.MouseEventHandler(this.pnlControlBar_MouseEnter);
========
            this.crystalReportsViewer = ((SAPBusinessObjects.WPF.Viewer.CrystalReportsViewer)(target));
            
            #line 14 "..\..\CommunityInfo.xaml"
            this.crystalReportsViewer.Loaded += new System.Windows.RoutedEventHandler(this.CrystalReportsViewer_Loaded);
            
            #line default
            #line hidden
            return;
            case 2:
            
            #line 15 "..\..\CommunityInfo.xaml"
            ((System.Windows.Controls.Button)(target)).Click += new System.Windows.RoutedEventHandler(this.Button_Click);
            
            #line default
            #line hidden
            return;
            case 3:
            
            #line 16 "..\..\CommunityInfo.xaml"
            ((System.Windows.Controls.Button)(target)).Click += new System.Windows.RoutedEventHandler(this.Button_Click_1);
>>>>>>>> Interfaz:PROYECTO COMUNIDAD/Proyecto Comunidad/Proyecto Comunidad/obj/Debug/CommunityInfo.g.cs
            
            #line default
            #line hidden
            return;
            }
            this._contentLoaded = true;
        }
    }
}
