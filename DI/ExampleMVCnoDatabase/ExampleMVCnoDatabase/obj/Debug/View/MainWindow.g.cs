﻿#pragma checksum "..\..\..\View\MainWindow.xaml" "{8829d00f-11b8-4213-878b-770e8597ac16}" "2B5AA1963DDD2B346B18A31BECFDF884C7C603C10FE00690D98625B5C07446E4"
//------------------------------------------------------------------------------
// <auto-generated>
//     Este código fue generado por una herramienta.
//     Versión de runtime:4.0.30319.42000
//
//     Los cambios en este archivo podrían causar un comportamiento incorrecto y se perderán si
//     se vuelve a generar el código.
// </auto-generated>
//------------------------------------------------------------------------------

using ExampleMVCnoDatabase;
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


namespace ExampleMVCnoDatabase {
    
    
    /// <summary>
    /// MainWindow
    /// </summary>
    public partial class MainWindow : System.Windows.Window, System.Windows.Markup.IComponentConnector {
        
        
        #line 14 "..\..\..\View\MainWindow.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.DataGrid dgvPeople;
        
        #line default
        #line hidden
        
        
        #line 21 "..\..\..\View\MainWindow.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.Button btnExample;
        
        #line default
        #line hidden
        
        
        #line 23 "..\..\..\View\MainWindow.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.TextBox Name;
        
        #line default
        #line hidden
        
        
        #line 25 "..\..\..\View\MainWindow.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.TextBox Age;
        
        #line default
        #line hidden
        
        
        #line 28 "..\..\..\View\MainWindow.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.Button New;
        
        #line default
        #line hidden
        
        
        #line 29 "..\..\..\View\MainWindow.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.Button Delete;
        
        #line default
        #line hidden
        
        
        #line 30 "..\..\..\View\MainWindow.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.Button Save;
        
        #line default
        #line hidden
        
        
        #line 31 "..\..\..\View\MainWindow.xaml"
        [System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1823:AvoidUnusedPrivateFields")]
        internal System.Windows.Controls.TextBlock Traza;
        
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
            System.Uri resourceLocater = new System.Uri("/ExampleMVCnoDatabase;component/view/mainwindow.xaml", System.UriKind.Relative);
            
            #line 1 "..\..\..\View\MainWindow.xaml"
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
            this.dgvPeople = ((System.Windows.Controls.DataGrid)(target));
            
            #line 14 "..\..\..\View\MainWindow.xaml"
            this.dgvPeople.SelectionChanged += new System.Windows.Controls.SelectionChangedEventHandler(this.dgvPeople_SelectionChangedGridPosition);
            
            #line default
            #line hidden
            return;
            case 2:
            this.btnExample = ((System.Windows.Controls.Button)(target));
            
            #line 21 "..\..\..\View\MainWindow.xaml"
            this.btnExample.Click += new System.Windows.RoutedEventHandler(this.btnExample_Click);
            
            #line default
            #line hidden
            return;
            case 3:
            this.Name = ((System.Windows.Controls.TextBox)(target));
            
            #line 23 "..\..\..\View\MainWindow.xaml"
            this.Name.TextChanged += new System.Windows.Controls.TextChangedEventHandler(this.Name_TextChanged);
            
            #line default
            #line hidden
            return;
            case 4:
            this.Age = ((System.Windows.Controls.TextBox)(target));
            
            #line 25 "..\..\..\View\MainWindow.xaml"
            this.Age.TextChanged += new System.Windows.Controls.TextChangedEventHandler(this.Age_TextChanged);
            
            #line default
            #line hidden
            return;
            case 5:
            this.New = ((System.Windows.Controls.Button)(target));
            
            #line 28 "..\..\..\View\MainWindow.xaml"
            this.New.Click += new System.Windows.RoutedEventHandler(this.ClickNewButton);
            
            #line default
            #line hidden
            return;
            case 6:
            this.Delete = ((System.Windows.Controls.Button)(target));
            
            #line 29 "..\..\..\View\MainWindow.xaml"
            this.Delete.Click += new System.Windows.RoutedEventHandler(this.ClickDeleteButton);
            
            #line default
            #line hidden
            return;
            case 7:
            this.Save = ((System.Windows.Controls.Button)(target));
            
            #line 30 "..\..\..\View\MainWindow.xaml"
            this.Save.Click += new System.Windows.RoutedEventHandler(this.ClickSaveButton);
            
            #line default
            #line hidden
            return;
            case 8:
            this.Traza = ((System.Windows.Controls.TextBlock)(target));
            return;
            }
            this._contentLoaded = true;
        }
    }
}
