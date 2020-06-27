<template>
  <a-form-model
    ref="ruleForm"
    :model="form"
    :rules="rules"
    :label-col="labelCol"
    :wrapper-col="wrapperCol"
  >
    <a-form-model-item ref="processDefinitionKey" label="Key Processo" prop="processDefinitionKey">
      <a-input
        v-model="form.processDefinitionKey"
        @blur="() => { $refs.processDefinitionKey.onFieldBlur();}"
      />
    </a-form-model-item>

    <a-form-model-item ref="processDefinitionName" label="Nome Processo" prop="processDefinitionName">
      <a-input
        v-model="form.processDefinitionName"
        @blur="() => { $refs.processDefinitionName.onFieldBlur();}"
      />
    </a-form-model-item>

    <a-form-model-item ref="description" label="Descrição Processo" prop="description">
      <a-input
        v-model="form.description"
        @blur="() => { $refs.description.onFieldBlur();}"
      />
    </a-form-model-item>

    <a-form-model-item ref="version" label="Versão Processo" prop="version">
      <a-input
        v-model="form.version"
        @blur="() => { $refs.processDefinitionKey.onFieldBlur();}"
      />
    </a-form-model-item>
   
    <a-form-model-item :wrapper-col="{ span: 14, offset: 4 }">
      <a-button type="primary" @click="onSubmit">
        Criar
      </a-button>
      <a-button style="margin-left: 10px;" @click="resetForm">
       Limpar
      </a-button>
    </a-form-model-item>
  </a-form-model>
</template>
<script>
import ProcessoService from '@/services/ProcessoService';
export default {
  data() {
    return {
      
      labelCol: { span: 4 },
      wrapperCol: { span: 14 },
      other: '',
      form: {
        processDefinitionKey: '',
        processDefinitionName: '',
        description:'',
        version:'',
      },
      rules: {
        processDefinitionKey: [
          { required: true, message: 'Campo Obrigatório!', trigger: 'blur' },
          { min: 2, max: 30, message: 'Deve conter entre 2 e 30 caracteres!', trigger: 'blur' },
        ],
         processDefinitionName: [
          { required: true, message: 'Campo Obrigatório!', trigger: 'blur' },
          { min: 2, max: 30, message: 'Deve conter entre 2 e 30 caracteres!', trigger: 'blur' },
        ],
         description: [
          { required: true, message: 'Campo Obrigatório!', trigger: 'blur' },
          { min: 2, max: 100, message: 'Deve conter entre 2 e 100 caracteres!', trigger: 'blur' },
        ],
         version: [
          { required: true, message: 'Campo Obrigatório!', trigger: 'blur' },
          { min: 1, max: 10, message: 'Deve conter entre 1 e 10 caracteres!', trigger: 'blur' },
        ],
       
      },
    };
  },
  mounted() {
    
    
  },
  methods: {
    onSubmit() {
      this.$refs.ruleForm.validate(valid => {
        if (valid) {
         
         ProcessoService.create(this.form, r => router.push('/processos'))
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
    resetForm() {
      this.$refs.ruleForm.resetFields();
    },
  },
};
</script>
